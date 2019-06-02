import React from "react";
import Nop from '../nop.jpg'
const FilterByLocation= ({ offers}) => (
    <div>
    <section className="hero  is-link is-fullheight ">
    <div className="hero-body">
    <div className="container ">
    <div className="table is-striped is-bordered is-link is-vertical ">
    <img src={Nop} alt="Photo"/>
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
                        <tr key={index}> 
                          <td>{offer.location}</td>
                               <td>{offer.title}</td>
                               <td>{offer.description}</td>
                             <td> {offer.creationDate}</td>
                           
                      
                          
                           
                            <td>{offer.author}</td>
                            <td>{offer.availableDate}</td>
                           
                        </tr>
                    ))
                }
            </tbody>
            
            </div>
            </div>
            </div>
            </section>
            </div>
   
);

export default FilterByLocation;