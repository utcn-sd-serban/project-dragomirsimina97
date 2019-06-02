import React, { Component } from "react";
import model from "../model/model";
import OffersList from "./OffersList";
import offersListPresenter from "../presenter/OffersListPresenter";

const mapModelStateToComponentState = modelState => ({
   offers: modelState.offers
});

export default class SmartOffersList extends Component {
    constructor() {
        super();
        this.state = mapModelStateToComponentState(model.state);
        this.listener = modelState => this.setState(mapModelStateToComponentState(modelState));
        model.addListener("change", this.listener);
       offersListPresenter.onInit();
    }

    componentWillUnmount() {
        model.removeListener("change", this.listener);
    }

    render() {
        return (
            <OffersList 
                onViewDetails={offersListPresenter.onViewDetails}
                onCreateOffer={offersListPresenter.onCreateOffer}
                offers={this.state.offers}
                onChangeToSearch={offersListPresenter.changeToSearch}
                searchOffersTitle={offersListPresenter.onFilterOffersTitle}
                searchOffersLocation={offersListPresenter.onFilterOffersLocation}
            />
        );
    }
}