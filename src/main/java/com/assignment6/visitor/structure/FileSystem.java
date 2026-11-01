package com.assignment6.visitor.structure;

import com.assignment6.visitor.element.FileSystemElement;
import com.assignment6.visitor.visitor.FileSystemVisitor;

import java.util.List;

public final class FileSystem {
    private final List<FileSystemElement> rootElements;

    public FileSystem(List<FileSystemElement> rootElements) {
        if (rootElements == null) {
            throw new IllegalArgumentException("Root elements must not be null");
        }
        this.rootElements = List.copyOf(rootElements);
    }

    public void accept(FileSystemVisitor visitor) {
        for (FileSystemElement element : rootElements) {
            element.accept(visitor);
        }
    }
}
