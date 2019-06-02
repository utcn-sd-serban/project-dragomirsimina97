import model from "../model/model";

class OffersListPresenter {
    onCreateOffer() {
        window.location.assign("#/create-offer");
    }

    onViewDetails(index) {
        window.location.assign("#/offer-details/" + index);
    }
    onFilterOffersTitle()
    {
        model.findByTitle();
        window.location.assign("#/filter-title-offer");
    }
    onFilterOffersLocation()
    {
        model.findByLocation();
        window.location.assign("#/filter-location-offer");
    }
    
    changeToSearch(property, value){
      model.changeToSearch(property, value);

    }
    onInit() {
        model.loadOffers();
    }
    
}

const offersListPresenter = new OffersListPresenter();

export default offersListPresenter;