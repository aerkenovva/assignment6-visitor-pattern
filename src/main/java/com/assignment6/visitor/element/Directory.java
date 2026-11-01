package com.assignment6.visitor.element;

import com.assignment6.visitor.visitor.FileSystemVisitor;

import java.util.List;

public final class Directory implements FileSystemElement {
    private final String name;
    private final List<FileSystemElement> children;

    public Directory(String name, List<FileSystemElement> children) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Directory name must not be blank");
        }
        if (children == null) {
            throw new IllegalArgumentException("Children must not be null");
        }
        this.name = name;
        this.children = List.copyOf(children);
    }

    public String getName() {
        return name;
    }

    public List<FileSystemElement> getChildren() {
        return children;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
        for (FileSystemElement child : children) {
            child.accept(visitor);
        }
    }
}
