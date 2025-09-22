package visitor;

public class Main {
    public static void main(String[] args) {
        Directory dir = new Directory("root");
        File textFile1 = new File("teksti1.txt", 2);
        File textFile2 = new File("teksti2.txt", 2);

        dir.add(textFile1);
        dir.add(textFile2);

        Directory subDir = new Directory("docs");
        File docFile1 = new File("dokumentti1.pdf", 2);
        File docFile2 = new File("dokumentti2.pdf", 2);

        subDir.add(docFile1);
        subDir.add(docFile2);

        dir.add(subDir);

        SizeCalculatorVisitor sizeCalculator = new SizeCalculatorVisitor();
        dir.accept(sizeCalculator);
        System.out.println("Total size: " + sizeCalculator.getTotalSize() + " MB");

        SearchVisitor searchVisitor = new SearchVisitor(".txt");
        dir.accept(searchVisitor);
        System.out.println("Found files: " + searchVisitor.getResults());
    }
}
