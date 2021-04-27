package mg.rheiin.main.functionnal;

public interface QueryExecutor<T, E> {
	public void didPersist(T entity, E error);
}	
