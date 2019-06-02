const BASE_URL = "http://localhost:8080";

export default class RestClient {
    constructor(username, password) {
        this.authorization = "Basic " + btoa(username + ":" + password);
    }

    loadAllOffers() {
        return fetch(BASE_URL + "/offers", {
            method: "GET",
            headers: {
                "Authorization": this.authorization
            }
        }).then(response => response.json());
    }

    createOffer(author,title,description,location,creationDate,availableDate) {
        return fetch(BASE_URL + "/questions", {
            method: "POST",
            body: JSON.stringify({
                author:author,
                title:title,
                description:description,
                location:location,
                creationDate:creationDate,
                availableDate:availableDate
            }),
            headers: {
                "Authorization": this.authorization,
                "Content-Type": "application/json"
            }
        }).then(response => response.json());
    }


    filterOfferByTitle(title)
    {
        return fetch (BASE_URL + "/offers/title/" + title, {
            method: "GET",
            headers:{
                "Authorization": this.authorization
            }
        }).then(response => response.json());
    }
    filterOfferByLocation(location)
    {
        return fetch (BASE_URL + "/offers/location/" +location, {
            method: "GET",
            headers:{
                "Authorization": this.authorization
            }
        }).then(response => response.json());
    }
}