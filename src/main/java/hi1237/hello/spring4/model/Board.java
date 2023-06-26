package hi1237.hello.spring4.model;

public class Board {

    private String bno;
    private String title;
    private String userid;
    private String regdate;
    private String views;
    private String contents;

    public Board(String bno, String title, String userid, String regdate, String views, String contents) {
        this.bno = bno;
        this.title = title;
        this.userid = userid;
        this.regdate = regdate;
        this.views = views;
        this.contents = contents;
    }

    public String getBno() {
        return bno;
    }

    public void setBno(String bno) {
        this.bno = bno;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    @Override
    public String toString() {
        return "Board{" +
                "bno='" + bno + '\'' +
                ", title='" + title + '\'' +
                ", userid='" + userid + '\'' +
                ", regdate='" + regdate + '\'' +
                ", views='" + views + '\'' +
                ", contents='" + contents + '\'' +
                '}';
    }
}
