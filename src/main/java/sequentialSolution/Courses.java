package sequentialSolution;

import java.util.Objects;

public class Courses {

    private String codeModule;
    private String codePresentation;
    private String modulePresentationLength;


    public Courses(String codeModule, String codePresentation, String modulePresentationLength) {
        this.codeModule = codeModule;
        this.codePresentation = codePresentation;
        this.modulePresentationLength = modulePresentationLength;
    }

    public Courses(){

    }

    public String getCodeModule() {
        return codeModule;
    }

    public void setCodeModule(String codeModule) {
        this.codeModule = codeModule;
    }

    public String getCodePresentation() {
        return codePresentation;
    }

    public void setCodePresentation(String codePresentation) {
        this.codePresentation = codePresentation;
    }

    public String getModulePresentationLength() {
        return modulePresentationLength;
    }

    public void setModulePresentationLength(String modulePresentationLength) {
        this.modulePresentationLength = modulePresentationLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Courses)) return false;
        Courses that = (Courses) o;
        return getCodeModule().equals(that.getCodeModule()) && getCodePresentation().equals(that.getCodePresentation()) && getModulePresentationLength().equals(that.getModulePresentationLength());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodeModule(), getCodePresentation(), getModulePresentationLength());
    }

    @Override
    public String toString() {
        return "Courses{" +
                "codeModule='" + codeModule + '\'' +
                ", codePresentation='" + codePresentation + '\'' +
                ", modulePresentationLength='" + modulePresentationLength + '\'' +
                '}';
    }
}
