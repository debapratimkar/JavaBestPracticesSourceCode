package modernjava.records;

import java.util.Objects;

class StandardBook {
    private final String title;
    private final String author;

    public StandardBook(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StandardBook that = (StandardBook) o;
        return Objects.equals(title, that.title) &&
                Objects.equals(author, that.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }

    @Override
    public String toString() {
        return "StandardBook[title=" + title + ", author=" + author + "]";
    }
}
