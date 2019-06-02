import React, { Component } from "react";
import model from "../model/model";

import FilterByTitle from "./FilterByTitle";
import OffersListPresenter from "../presenter/OffersListPresenter"


const mapModelStateToComponentState = modelState => ({
    searchOffers:modelState.searchOffers
});

export default class SmartFilterByTitle extends Component {
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
            <FilterByTitle
              offers={this.state.searchOffers}
               onViewDetails={OffersListPresenter.onViewDetails}
               />
        );
    }
}