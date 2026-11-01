package com.assignment6.visitor.visitor;

import com.assignment6.visitor.element.Directory;
import com.assignment6.visitor.element.RegularFile;

public final class SizeCalculatorVisitor implements FileSystemVisitor {
    private long totalSizeInBytes;

    @Override
    public void visit(RegularFile file) {
        totalSizeInBytes += file.getSizeInBytes();
    }

    @Override
    public void visit(Directory directory) {
        // Directories do not add bytes in this simplified model.
    }

    public long getTotalSizeInBytes() {
        return totalSizeInBytes;
    }
}
