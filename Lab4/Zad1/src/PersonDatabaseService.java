

import java.sql.SQLException;

public interface PersonDatabaseService {
	int AddPerson(Person person) throws SQLException;
	int remove(int id) throws SQLException;
	Person read(int id) throws SQLException;
	int update(int id) throws SQLException;
}
