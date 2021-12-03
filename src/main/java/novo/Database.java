package novo;
import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;


public class Database {
    Connection connection;
    Statement statement;
    Result result;
    PreparedStatement pst;

    static final String user = "root";
    static final String password = "sP*#HU8xd!1&";
    static final String database = "projeto";

    static final String url = "jdbc:mysql://localhost:3306/" + database + "?useTimezone=true&serverTimezone=UTC&useSSL=false";
    private boolean check = false;

    public void connect()
    {
        try{
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão feita com sucesso: "+ connection);
        }catch (SQLException e){
            System.out.println("Erro de conexão: "+e.getMessage());
        }

    }

    public boolean insertUser(Pessoa usuario) {
        connect();
        String sql = "INSERT INTO usuario(nome,cpf,data_nascimento,sexo,endereco) VALUES (?,?,?,?,?)";

        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1,usuario.getNome());
            pst.setString(2,usuario.getCpf());
            check true;

        } catch (SQLException e)
        {
            System.out.println("Erro de operação: "+ e.getMessage());
            check false;
        }

        finally {
            try {
                connection.close();
                pst.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexão: "+ e.getMessage());
            }
        }
        return check;
    }

    public ArrayList<Pessoa> researchUser(){
        connect();
        ArrayList<Pessoa> users = new ArrayList<>();
        String sql = "SELECT * FROM usuario";
        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);
            while(result.next()){
                Pessoa userTemp = new Pessoa(result.getString("nome"), result.getString("cpf"));
                userTemp.id = result.getInt("id");
                System.out.println("ID = " + userTemp.id);
                System.out.println("Nome = " + userTemp.getNome());
                System.out.println("CPF = " + userTemp.getCpf());
                System.out.println("Data de nascimento = " + userTemp.getData_nascimento());
                System.out.println("Sexo = " + userTemp.getSexo());
                System.out.println("Endereco = " + userTemp.getEndereco());
                System.out.println("------------------------------");
                users.add(userTemp);
            }
        }catch (SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
        }finally {
            try {
                connection.close();
                statement.close();
                result.close();
            }catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return users;
    }

    public ArrayList<Pessoa> researchUserCpf(String cpf){
        connect();
        ArrayList<Pessoa> users = new ArrayList<>();
        String sql = "SELECT * FROM usuario WHERE cpf = '" + cpf + "'";
        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);
            while(result.next()){
                Pessoa userTemp = new Pessoa(result.getString("nome"), result.getString("cpf"));
                userTemp.id = result.getInt("id");
                System.out.println("ID = " + userTemp.id);
                System.out.println("Nome = " + userTemp.getNome());
                System.out.println("CPF = " + userTemp.getCpf());
                System.out.println("Data de nascimento = " + userTemp.getData_nascimento());
                System.out.println("Sexo = " + userTemp.getSexo());
                System.out.println("Endereco = " + userTemp.getEndereco());
                System.out.println("------------------------------");
                users.add(userTemp);
            }
        }catch (SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
        }finally {
            try {
                connection.close();
                statement.close();
                result.close();
            }catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return users;
    }

    public boolean updateUser(int id, String nome){
        connect();
        String sql = "UPDATE usuario SET nome=? WHERE id=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1, nome);
            pst.setInt(2, id);
            pst.execute();
            check = true;
        }catch (SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
            check = false;
        }finally {
            try {
                connection.close();
                pst.close();
            }catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return check;
    }

    public boolean deleteUser(int id) {
        connect();
        String sql = "DELETE FROM usuario WHERE id=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            check = true;
        }catch (SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
            check = false;
        }finally {
            try {
                connection.close();
                pst.close();
            }catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return check;
    }
}
