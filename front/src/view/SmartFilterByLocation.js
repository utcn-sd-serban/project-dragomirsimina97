import React, { Component } from "react";
import model from "../model/model";

import FilterByLocation from "./FilterByLocation";
import OffersListPresenter from "../presenter/OffersListPresenter"


const mapModelStateToComponentState = modelState => ({
    searchOffers:modelState.searchOffers
});

export default class SmartFilterByLocation extends Component {
    constructor() {
        super();
        this.state = mapModelStateToComponentState(model.state);
        this.listener = modelState => this.setState(mapModelStateToComponentState(modelState));
        model.addListener("change", this.listener);
    }

    componentWillUnmount() {
        model.removeListener("change", this.listener);
    }

    render() {
        return (
            <FilterByLocation
              offers={this.state.searchOffers}
               onViewDetails={OffersListPresenter.onViewDetails}
               />
        );
    }
}