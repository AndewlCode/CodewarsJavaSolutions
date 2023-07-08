package Classes.PaginationHelper;

import java.util.List;

public class PaginationHelper<I> {
    private final List<I> collection;
    private final int itemsPerPage;

    /**
     * The constructor takes in an array of items and a integer indicating how many
     * items fit within a single page
     */
    public PaginationHelper(List<I> collection, int itemsPerPage) {
        this.collection = collection;
        this.itemsPerPage = itemsPerPage;
    }

    /**
     * returns the number of items within the entire collection
     */
    public int itemCount() {
        return this.collection.size();
    }

    /**
     * returns the number of pages
     */
    public int pageCount() {
        if (this.collection.size() % this.itemsPerPage == 0) {
            return this.collection.size() / this.itemsPerPage;
        } else {
            return this.collection.size() / this.itemsPerPage + 1;
        }
    }

    /**
     * returns the number of items on the current page. page_index is zero based.
     * this method should return -1 for pageIndex values that are out of range
     */
    public int pageItemCount(int pageIndex) {
        int totalPages = this.pageCount();
        int totalElements = this.collection.size();

        // Check illegal values
        if (pageIndex < 0 || pageIndex > totalPages - 1) {
            return -1;
        }

        // Count elements by page
        if (totalElements - (pageIndex * this.itemsPerPage) > this.itemsPerPage) {
            return this.itemsPerPage;
        } else {
            return totalElements - this.itemsPerPage * (pageIndex);
        }
    }

    /**
     * determines what page an item is on. Zero based indexes
     * this method should return -1 for itemIndex values that are out of range
     */
    public int pageIndex(int itemIndex) {

        // Check illegal values
        if (itemIndex < 0 || itemIndex >= this.collection.size()) {
            return -1;
        }

        // Count page index
        int pages = this.pageCount();
        for (int pageIndex = 0; pageIndex < pages; pageIndex++) {
            if ((pageIndex + 1) * this.itemsPerPage > itemIndex) {
                return pageIndex;
            }
        }

        return 0;
    }
}