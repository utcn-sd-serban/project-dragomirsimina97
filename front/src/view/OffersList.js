import React from "react";
import Positano from '../photoo.jpg'
import Dap from '../dap.jpg'
const OffersList = ({ offers,onCreateOffer, onViewDetails ,searchOffersLocation,searchOffersTitle,onChangeToSearch}) => (
    <div>
      <section className="hero is-link is-fullheight ">
      <img src={Positano} alt="Photo"/>
      <div className="hero-body">
      <div className="container ">
 
        <p className="title ">Offers </p>
   
        <a className="button is-danger is-outlined is-left"
          onClick={onCreateOffer} >Create Offer
 </a>
 <img src={Dap} alt="Photo"/>
 <input onChange={e =>onChangeToSearch("toSearch",e.target.value)}></input>
                <a className="button is-danger is-outlined " onClick={searchOffersTitle}>
    
                    Title
                </a>
<input onChange={e =>onChangeToSearch("toSearch",e.target.value)}></input>
                <a className="button is-danger is-outlined " onClick={searchOffersLocation}>
    
                   Author
                </a>
               
 </div>


                
    
<div className="table is-striped is-bordered is-link is-vertical ">
   
<thead>
    <tr>
        <th>Author </th>
        <th>Title</th>
        <th>Description</th>
        <th>Location</th>
        <th>CreationDate</th>
        <th>AvailableDate</th>
    </tr>
</thead>
            <tbody>
                { 
                    offers.map((offer, index) => (
                        <tr key={index} >
                               <td>{offer.location}</td>
                               <td>{offer.title}</td>
                               <td>{offer.description}</td>
                             <td> {offer.creationDate}</td>
                           
                      
                          
                           
                            <td>{offer.author}</td>
                            <td>{offer.availableDate}</td>
                            <td><a onClick={() => onViewDetails(index)} class="button is-danger is-outlined">View Details</a></td> 
                           
                        </tr>
                    ))
                }
            </tbody>
    </div>
      
        
        </div> 
                
        </section>
    </div>
);

export default OffersList;