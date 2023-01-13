package sequentialSolution;

public class StudentVle {

    String codeModule;
    String codePresentation;
    String idStudent;
    String idSite;
    String date;
    String sumClick;


    public StudentVle(String codeModule, String codePresentation, String idStudent, String idSite, String date, String sumClick) {
        this.codeModule = codeModule;
        this.codePresentation = codePresentation;
        this.idStudent = idStudent;
        this.idSite = idSite;
        this.date = date;
        this.sumClick = sumClick;
    }

    public StudentVle(){
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

    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    public String getIdSite() {
        return idSite;
    }

    public void setIdSite(String idSite) {
        this.idSite = idSite;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSumClick() {
        return sumClick;
    }

    public void setSumClick(String sumClick) {
        this.sumClick = sumClick;
    }

    @Override
    public String toString() {
        return "StudentVle{" +
                "codeModule='" + codeModule + '\'' +
                ", codePresentation='" + codePresentation + '\'' +
                ", idStudent=" + idStudent +
                ", idSite=" + idSite +
                ", date=" + date +
                ", sumClick=" + sumClick +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentVle)) return false;

        StudentVle that = (StudentVle) o;

        if (!getCodeModule().equals(that.getCodeModule())) return false;
        if (!getCodePresentation().equals(that.getCodePresentation())) return false;
        if (!getIdStudent().equals(that.getIdStudent())) return false;
        if (!getIdSite().equals(that.getIdSite())) return false;
        if (!getDate().equals(that.getDate())) return false;
        return getSumClick().equals(that.getSumClick());
    }

    @Override
    public int hashCode() {
        int result = getCodeModule().hashCode();
        result = 31 * result + getCodePresentation().hashCode();
        result = 31 * result + getIdStudent().hashCode();
        result = 31 * result + getIdSite().hashCode();
        result = 31 * result + getDate().hashCode();
        result = 31 * result + getSumClick().hashCode();
        return result;
    }
}
