import React from "react";
import Bali from '../bali.jpg'
const AuthorDetails = ({ first_name,last_name,phone,review }) => (
    <div>
        <section className="hero is-link is-fullheight">
        <img src={Bali} alt="Photo"/>
        <div className="hero-body">
      <div className="container ">


    <div className="tile is-ancestor">
        <div className="tile is-4 is-vertical is-parent ">


            <p className="tag is-danger is-large ">Author</p>

            <p className="tag is-succes is-large ">FirstName:</p>
            <span className="tag is-warning"> {first_name }</span>
            <br />
            <p className="tag is-succes is-large">LatName:</p>
            <span className="tag is-warning"> { last_name}</span>
            <br />
            <p className="tag is-succes is-large">Phone:</p>
            <span className="tag is-warning"> { phone}</span>
            <br />
            <p className="tag is-succes is-large">Review:</p>
            <span className="tag is-warning"> { review}</span>
            <br />
           
        </div>
                    </div>

                </div>
            </div>

        </section>
    </div>
);

export default AuthorDetails;