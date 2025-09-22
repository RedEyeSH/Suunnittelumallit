package visitor;

import java.util.ArrayList;
import java.util.List;

public class SearchVisitor implements FileSystemVisitor {
    private String search;
    private List<File> results = new ArrayList<>();

    public SearchVisitor(String search) {
        this.search = search;
    }

    public List<File> getResults() {
        return results;
    }

    @Override
    public void visit(File file) {
        if (file.getName().contains(search)) {
            results.add(file);
        }
    }

    @Override
    public void visit(Directory directory) {
    }
}
