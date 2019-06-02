import React from "react";
import Bali from '../bali.jpg'
const OfferDetails = ({ author,title,description,location,creationDate,availableDate }) => (
    <div>
        <section className="hero is-link is-fullheight">
        <img src={Bali} alt="Photo"/>
        <div className="hero-body">
      <div className="container ">


    <div className="tile is-ancestor">
        <div className="tile is-4 is-vertical is-parent ">


            <p className="tag is-danger is-large ">Offer</p>

            <p className="tag is-succes is-large ">Author:</p>
            <span className="tag is-warning"> { author }</span>
            <br />
            <p className="tag is-succes is-large">Title:</p>
            <span className="tag is-warning"> { title}</span>
            <br />
            <p className="tag is-succes is-large">Location:</p>
            <span className="tag is-warning"> { location}</span>
            <br />
            <p className="tag is-succes is-large">CreationDate:</p>
            <span className="tag is-warning"> { creationDate }</span>
            <br />
            <p className="tag is-succes is-large">Description:</p>
            <span className="tag is-warning"> { description }</span>
             <br />
             <p className="tag is-succes is-large">AvailableDate:</p>
            <span className="tag is-warning "> { availableDate }</span>
            <br />
        </div>
                    </div>

                </div>
            </div>

        </section>
    </div>
);

export default OfferDetails;