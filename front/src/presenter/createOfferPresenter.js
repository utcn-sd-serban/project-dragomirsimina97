import model from "../model/model";


class CreateOfferPresenter {

    onCreate() {
        model.addOffer(model.state.newOffer.author, model.state.newOffer.title, model.state.newOffer.description,model.state.newOffer.location,model.state.newOffer.creationDate,model.state.newOffer.availableDate)
        .then(() => {
            model.changeNewOfferProperty("author", "");
            model.changeNewOfferProperty("title", "");
            model.changeNewOfferProperty("description", "");
            model.changeNewOfferProperty("location", "");
            model.changeNewOfferProperty("creationDate", "");
            model.changeNewOfferProperty("availableDate", "");
            window.location.assign("#/");
        });
       
    }

    onChange(property, value) {
        model.changeNewOfferProperty(property, value);
    }

}

const createOfferPresenter = new CreateOfferPresenter();


export default createOfferPresenter;