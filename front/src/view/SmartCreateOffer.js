import React, { Component } from "react";
import model from "../model/model";

import CreateOffer from "./CreateOffer";
import createOfferPresenter from "../presenter/createOfferPresenter";

const mapModelStateToComponentState = modelState => ({
    author: modelState.newOffer.author,
    title:modelState.newOffer.title,
    description: modelState.newOffer.description,
  location:  modelState.newOffer.location,
    creationDate: modelState.newOffer.creationDate,
   availableDate:modelState.newOffer.availableDate

});

export default class SmartCreateOffer extends Component {
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
            <CreateOffer
                onCreate={createOfferPresenter.onCreate}
                onChange={createOfferPresenter.onChange}
               author={this.state.author}
               title={this.state.title}
              description={this.state.description}
              location={this.state.location}
               creationDate={this.state.creationDate}
               availableDate={this.state.availableDate} />
        );
    }
}