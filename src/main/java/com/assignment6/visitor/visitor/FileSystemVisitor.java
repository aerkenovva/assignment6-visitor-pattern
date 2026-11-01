package com.assignment6.visitor.visitor;

import com.assignment6.visitor.element.Directory;
import com.assignment6.visitor.element.RegularFile;

public interface FileSystemVisitor {
    void visit(RegularFile file);

    void visit(Directory directory);
}
