import { EventEmitter } from "events";
import RestClient from "../rest/RestClient";


const client = new RestClient("raluca", "password");
class Model extends EventEmitter {
    constructor() {
        super();
        this.state = {
            offers: [],
            newOffer: {
               id:"",
                author:"",
                title:"",
               description:"",
               location:"",
                creationDate:"",
                availableDate:"" 
            },
            searchOffers: [],
            toSearch:""            
        };
    }

    loadOffers()
    {
        return client.loadAllOffers().then(offers => {
            this.state = { 
                ...this.state, 
               offers:offers
            };
            this.emit("change", this.state);
        })
    }

    addOffer(author,title,description,location,creationDate,availableDate) {

        return client.createOffer(author,title,description,location,creationDate,availableDate)
        .then(offer=> {this.state = {
            ...this.state,
            currentId:++this.state.currentId,
            offers: this.state.offers.concat([{
             id:this.state.currentId,  
              author:author,
               title:title,
               description:description,
               location:location,
               creationDate:creationDate,
               availableDate:availableDate
            }])
        };
        this.emit("change", this.state);
       
    })}
  
    changeNewOfferProperty(property, value) {
        this.state = {
            ...this.state,
            newOffer: {
                ...this.state. newOffer,
                [property]: value
            }
        };
        this.emit("change", this.state);
    }
    findByTitle(){ 
       
        return client.filterOfferByTitle(this.state.toSearch).then(offers => {
            this.state = {
                ...this.state,
                searchOffers: offers
            };
            this.emit("change", this.state);
        });
 }
 findByLocation(){ 
       
    return client.filterOfferByLocation(this.state.toSearch).then(offers => {
        this.state = {
            ...this.state,
            searchOffers: offers
        };
        this.emit("change", this.state);
    });
}
 changeToSearch(property, value) {
    this.state = {
        ...this.state,
       [property]:value
    };
    this.emit("change", this.state);
}

    
}

const model = new Model();

export default model;