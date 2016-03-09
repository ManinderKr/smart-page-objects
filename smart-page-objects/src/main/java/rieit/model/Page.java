package rieit.model;

public interface Page {

	public String getUrl();

	public boolean isReady();

	public void open();

	public void reload();

}
