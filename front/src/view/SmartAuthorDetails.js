import React, { Component } from "react";
import model from "../model/model";

import AuthorDetails from "./AuthorDetails";

const mapModelStateToComponentState = (modelState, props) => (
    modelState.authors[props.match.params.index]
)

export default class SmartAuthorDetails extends Component {
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
            <AuthorDetails
              first_name={this.state.first_name}
              last_name={this.state.last_name}
               phone={this.state.phone}
               review={this.state.review}
             />
        );
    }
}