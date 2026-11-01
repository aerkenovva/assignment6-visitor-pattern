package com.assignment6.visitor.element;

import com.assignment6.visitor.visitor.FileSystemVisitor;

public final class RegularFile implements FileSystemElement {
    private final String name;
    private final long sizeInBytes;

    public RegularFile(String name, long sizeInBytes) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("File name must not be blank");
        }
        if (sizeInBytes < 0) {
            throw new IllegalArgumentException("File size must not be negative");
        }
        this.name = name;
        this.sizeInBytes = sizeInBytes;
    }

    public String getName() {
        return name;
    }

    public long getSizeInBytes() {
        return sizeInBytes;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
    }
}
