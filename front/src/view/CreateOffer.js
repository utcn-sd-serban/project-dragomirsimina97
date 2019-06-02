import React from "react";
import NewYork from '../newy.jpg'
const CreateOffer = ({ author,title,description,location,creationDate,availableDate, onCreate, onChange }) => (
    <div>
    <section className="hero is-link is-fullheight"> 
    <div className="hero-body">
      <div className="container ">
      <img src={NewYork} alt="Photo"/>
        <a className="button is-danger  is-outlined" onClick={onCreate} >Create</a>
 
        <div>
    

<article className="title is-child">
<div className="title is-ancestor">
        <div className="title is-vertical is-parent ">

            <input
                    className="input is-danger is-focused" type="author" placeholder="Author"
                    value={author} data-cy="author" onChange={ e => onChange("author", e.target.value)  }/>
            <br />
                <input
                    className="input is-danger is-focused" type="text" placeholder="Title"
                    value={title} data-cy="title" onChange={ e => onChange("title", e.target.value)  }/>
         <br/>
   
                <input
                    className="input is-danger is-focused" type="description" placeholder="Description"
                    value={description} data-cy="description" onChange={e => onChange("description", e.target.value)}/>
            
            <br/>
            <input
                    className="input is-danger is-focused" type="location" placeholder="Location"
                    value={location} data-cy="location" onChange={e => onChange("location", e.target.value)}/>
            
            <br/>
   
                <input
                    className="input is-danger is-focused" type="creationDate" placeholder="Creation Date"
                    value={creationDate} data-cy="creationDate"onChange={ e => onChange("creationDate", e.target.value)  }/>
        
     
        <br/>
   
        <input
                    className="input is-danger is-focused" type="availableDate" placeholder="AvailableDate"
                    value={availableDate} data-cy="availableDate"onChange={ e => onChange("availableDate", e.target.value)  }/>
        
     
        <br/>
         
              
        </div>
</div>
    
  </article>
   </div>
   </div>
   </div>
    </section>
    </div>
);

export default CreateOffer;