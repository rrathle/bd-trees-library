import model.Book;
import org.apache.commons.lang3.NotImplementedException;
import treestructure.BookNode;

/**
 * Application to test traversing Binary Trees and Binary Search Trees.
 *
 * Represents a Library with a collection of books.
 */
public class LibraryService {

    /**
     * The root node of our tree of Books.
     * Assume this tree is sorted by ISBN.
     * The tree and its nodes should not be modified by our application.
    */
    private final BookNode books;

    /**
     * Constructs our library with a default tree of books.
     * Assume this tree is sorted by ISBN.
     *
     * @param books The root node of a tree of Books
     */
    public LibraryService(final BookNode books) {
        this.books = books;
    }

    /**
     * Determines whether or not a book is in the library
     * by searching our tree for a book with the given ISBN.
     *
     * @param isbn A given ISBN to search our library for
     * @return True if a book with the given ISBN is in our library and
     *         false otherwise
     */
    public boolean isBookInLibraryByIsbn(String isbn) {
        // PARTICIPANTS: IMPLEMENT YOUR BINARY SEARCH HERE

        //if the isbn is null or empty String, return false
        if (isbn == null || isbn.isEmpty()) {
            return false;
        }

        BookNode current = books;

        while (current!= null) {
            int compare = isbn.compareTo(current.getBook().getIsbn());

            if (compare == 0)  {
                return true;
            } else if (compare < 0 ) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }

        }

        return false;
    }


    /**
     * Determines whether or not a book is in the library
     * by searching our tree for a book with the given Title and Author.
     *
     * @param title A given title to search our library for, alongside an author's name
     * @param author The name of a given author to search our library for, alongside a title
     * @return True if a book with the given title and author is in our library, and
     *         false otherwise
     */
    public boolean isBookInLibraryByTitleAndAuthor(String title, String author) {
        // PARTICIPANTS: IMPLEMENT YOUR DEPTH FIRST SEARCH HERE
        if (title == null || title.isEmpty() || author == null || author.isEmpty()) {
            return false;
        }

        return dfsSearch(books, title, author);
    }

    // Helper method for DFS traversal
    private boolean dfsSearch(BookNode node, String title, String author) {
        if (node == null) {
            return false; // Base case: reached a leaf
        }

        Book book = node.getBook();

        // Check if the current book matches
        if (book.getTitle().equals(title) && book.getAuthor().equals(author)) {
            return true;
        }
        return dfsSearch(node.getLeft(), title, author) || dfsSearch(node.getRight(), title, author);

    }
}
