package org.company.project.module.services;

import java.util.List;

import javax.jws.WebService;

import org.company.project.module.model.Book;
import org.company.project.module.model.LibraryFullException;

@WebService
public interface Library {
	List<Book> getAllBooks();
	String addBook(Book book) throws LibraryFullException;
}

