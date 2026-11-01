package com.assignment6.visitor.element;

import com.assignment6.visitor.visitor.FileSystemVisitor;

public interface FileSystemElement {
    void accept(FileSystemVisitor visitor);
}
