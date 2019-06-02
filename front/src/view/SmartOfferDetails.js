import React, { Component } from "react";
import model from "../model/model";

import OfferDetails from "./OfferDetails";

const mapModelStateToComponentState = (modelState, props) => (
    modelState.offers[props.match.params.index]
)

export default class SmartOfferDetails extends Component {
    constructor(props) {
        super(props);
        this.state = mapModelStateToComponentState(model.state, props);
        this.listener = modelState => this.setState(mapModelStateToComponentState(modelState, this.props));
        model.addListener("change", this.listener);
    }

    componentDidUpdate(prev) {
        if (prev.match.params.index !== this.props.match.params.index) {
            this.setState(mapModelStateToComponentState(model.state, this.props));
        }
    }

    componentWillUnmount() {
        model.removeListener("change", this.listener);
    }

    render() {
        return (
            <OfferDetails
               author={this.state.author}
               title={this.state.title}
               description={this.state.description}
               location={this.state.location}
               creationDate={this.state.creationDate} 
              availableDate={this.state.availableDate}  />
        );
    }
}