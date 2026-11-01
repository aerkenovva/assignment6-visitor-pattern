package com.assignment6.visitor;

import com.assignment6.visitor.element.Directory;
import com.assignment6.visitor.element.RegularFile;
import com.assignment6.visitor.structure.FileSystem;
import com.assignment6.visitor.visitor.FileSystemVisitor;
import com.assignment6.visitor.visitor.SearchVisitor;
import com.assignment6.visitor.visitor.SizeCalculatorVisitor;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VisitorPatternTest {

    @Test
    void sizeVisitorCalculatesTotalSize() {
        FileSystem fileSystem = Main.createSampleFileSystem();
        SizeCalculatorVisitor visitor = new SizeCalculatorVisitor();

        fileSystem.accept(visitor);

        assertEquals(12_500, visitor.getTotalSizeInBytes());
    }

    @Test
    void searchVisitorFindsMatchingFiles() {
        FileSystem fileSystem = Main.createSampleFileSystem();
        SearchVisitor visitor = new SearchVisitor(".txt");

        fileSystem.accept(visitor);

        assertEquals(List.of("notes.txt", "todo.txt"), visitor.getMatchingFiles());
    }

    @Test
    void acceptUsesCorrectVisitOverloadForDoubleDispatch() {
        List<String> calls = new ArrayList<>();
        FileSystemVisitor visitor = new FileSystemVisitor() {
            @Override
            public void visit(RegularFile file) {
                calls.add("file:" + file.getName());
            }

            @Override
            public void visit(Directory directory) {
                calls.add("directory:" + directory.getName());
            }
        };

        Directory root = new Directory("root", List.of(new RegularFile("a.txt", 10)));
        root.accept(visitor);

        assertEquals(List.of("directory:root", "file:a.txt"), calls);
    }
}
