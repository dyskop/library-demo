package by.skopinau.librarydemo.api.controller;

import by.skopinau.librarydemo.bll.service.PublisherService;
import by.skopinau.librarydemo.dal.entity.Publisher;
import by.skopinau.librarydemo.bll.exception.PublisherNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("library")
@RequiredArgsConstructor
public class PublisherController {

    @Autowired
    private final PublisherService publisherService;

    @GetMapping("/publishers")
    public List<Publisher> retrieveAllPublishers() {
        return publisherService.findAll();
    }

    @GetMapping("/publishers/{id}")
    public Publisher retrievePublisher(@PathVariable int id) throws PublisherNotFoundException {
        Optional<Publisher> publisher = publisherService.findById(id);

        if (publisher.isEmpty()) {
            throw new PublisherNotFoundException("id-" + id);
        }

        return publisher.get();
    }

    @DeleteMapping("/publishers/{id}")
    public void deletePublisher(@PathVariable int id) {
        publisherService.deleteById(id);
    }

    @PostMapping("/publishers")
    public ResponseEntity<Publisher> createPublisher(@RequestBody Publisher publisher) {
        Publisher savedPublisher = publisherService.save(publisher);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedPublisher.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/publishers/{id}")
    public ResponseEntity<Publisher> updatePublisher(@RequestBody Publisher publisher, @PathVariable int id) {
        Optional<Publisher> publisherOptional = publisherService.findById(id);

        if (publisherOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        publisher.setId(id);

        publisherService.save(publisher);

        return ResponseEntity.noContent().build();
    }
}
