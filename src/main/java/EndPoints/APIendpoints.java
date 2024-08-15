package EndPoints;

public enum APIendpoints {

    UserLogin("/login"),
    UserLogout("/logoutdietician"),
    CreateDietician("/dietician"),
    UpdateDietician("/dietician/{{dietId}}"),
    GetAllDieticians("/dietician"),
    GetDieticianById("/dietician/{{dietId}}"),
    DeleteDieticianById("/dietician/{{dietId}}");


    private String path;

    APIendpoints(String path){
        this.path = path;
    }

    public String getPath(){
        return path;
    }
}
