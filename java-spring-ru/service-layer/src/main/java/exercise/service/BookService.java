package exercise.service;

import exercise.dto.*;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.BookMapper;
import exercise.model.Author;
import exercise.model.Book;
import exercise.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    // BEGIN
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;

    public List<BookDTO> getAll() {
        List<Book> authors = bookRepository.findAll();
        return authors.stream().map(bookMapper::map).toList();
    }

    public BookDTO create(BookCreateDTO postDto) {
        Book author = bookMapper.map(postDto);
        bookRepository.save(author);
        return bookMapper.map(author);
    }

    public BookDTO findById(Long id) {
        Book author = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
        return bookMapper.map(author);
    }

    public BookDTO update(BookUpdateDTO postDto, Long id) {
        Book author = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
        bookMapper.update(postDto, author);
        bookRepository.save(author);

        return bookMapper.map(author);
    }

    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
    // END
}
