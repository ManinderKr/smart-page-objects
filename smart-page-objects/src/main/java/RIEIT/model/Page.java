package RIEIT.model;

public interface Page {

	public String getUrl();

	public boolean isReady();

	public void open();

	public void reload();

	public Object /* TODO: What should this be? */ getComponents();

}
