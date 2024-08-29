package HomeWork1.server;
public interface Repository<T> {
    void saveInLog(T text);
    T readFromLog();
}