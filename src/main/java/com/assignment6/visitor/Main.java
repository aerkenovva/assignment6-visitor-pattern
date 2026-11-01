package com.assignment6.visitor;

import com.assignment6.visitor.element.Directory;
import com.assignment6.visitor.element.RegularFile;
import com.assignment6.visitor.structure.FileSystem;
import com.assignment6.visitor.visitor.SearchVisitor;
import com.assignment6.visitor.visitor.SizeCalculatorVisitor;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        FileSystem fileSystem = createSampleFileSystem();

        SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();
        fileSystem.accept(sizeVisitor);

        SearchVisitor searchVisitor = new SearchVisitor(".txt");
        fileSystem.accept(searchVisitor);

        System.out.println("VISITOR PATTERN - FILE SYSTEM");
        System.out.println("=============================");
        System.out.println("Total size: " + sizeVisitor.getTotalSizeInBytes() + " bytes");
        System.out.println("Files matching '.txt': " + searchVisitor.getMatchingFiles());
    }

    static FileSystem createSampleFileSystem() {
        Directory images = new Directory("images", List.of(
                new RegularFile("logo.png", 2_400),
                new RegularFile("diagram.png", 3_100)
        ));

        Directory documents = new Directory("documents", List.of(
                new RegularFile("report.pdf", 5_000),
                new RegularFile("todo.txt", 800)
        ));

        Directory root = new Directory("root", List.of(
                new RegularFile("notes.txt", 1_200),
                images,
                documents
        ));

        return new FileSystem(List.of(root));
    }
}
