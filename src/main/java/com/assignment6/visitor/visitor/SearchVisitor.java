package com.assignment6.visitor.visitor;

import com.assignment6.visitor.element.Directory;
import com.assignment6.visitor.element.RegularFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class SearchVisitor implements FileSystemVisitor {
    private final String query;
    private final List<String> matchingFiles = new ArrayList<>();

    public SearchVisitor(String query) {
        if (query == null || query.isBlank()) {
            throw new IllegalArgumentException("Search query must not be blank");
        }
        this.query = query.toLowerCase(Locale.ROOT);
    }

    @Override
    public void visit(RegularFile file) {
        if (file.getName().toLowerCase(Locale.ROOT).contains(query)) {
            matchingFiles.add(file.getName());
        }
    }

    @Override
    public void visit(Directory directory) {
        // This visitor searches files only.
    }

    public List<String> getMatchingFiles() {
        return List.copyOf(matchingFiles);
    }
}
