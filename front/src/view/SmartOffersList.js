import React, { Component } from "react";
import model from "../model/model";
import OffersList from "./OffersList";
import offersListPresenter from "../presenter/OffersListPresenter";
import authorsListPresenter from "../presenter/AuthorListPresenter";

const mapModelStateToComponentState = modelState => ({
   offers: modelState.offers,
   authors:modelState.authors
});

export default class SmartOffersList extends Component {
    constructor() {
        super();
        this.state = mapModelStateToComponentState(model.state);
        this.listener = modelState => this.setState(mapModelStateToComponentState(modelState));
        model.addListener("change", this.listener);
       offersListPresenter.onInit();
       authorsListPresenter.onInit();
    }

    componentWillUnmount() {
        model.removeListener("change", this.listener);
    }

    render() {
        return (
            <OffersList 
            onViewAuthorDetails={offersListPresenter.onViewAuthorDetails}
                onViewDetails={offersListPresenter.onViewDetails}
                onCreateOffer={offersListPresenter.onCreateOffer}
                offers={this.state.offers}
                authors={this.state.authors}
                onChangeToSearch={offersListPresenter.changeToSearch}
                searchOffersTitle={offersListPresenter.onFilterOffersTitle}
                searchOffersLocation={offersListPresenter.onFilterOffersLocation}
            />
        );
    }
}