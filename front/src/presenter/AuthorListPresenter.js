import model from "../model/model";

class AuthorListPresenter {
  
    onViewAuthorDetails(index) {
        window.location.assign("#/author-details/" + index);
    }
   
    
    changeToSearch(property, value){
      model.changeToSearch(property, value);

    }
    onInit() {
        model.loadAuthor();
    }
    
}

const authorsListPresenter = new AuthorListPresenter();

export default authorsListPresenter;