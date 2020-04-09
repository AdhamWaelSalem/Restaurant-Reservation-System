package Finances.Statement;

public abstract class StatementItem {

    protected String Title;
    protected String Value;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }
}
