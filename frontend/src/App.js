import { useState } from "react";

import AppHeader from "./components/AppHeader";
import SearchPanel from "./components/SearchPanel";
import EventsList from "./components/EventsList";
import EventInfo from "./components/EventInfo";

import "./style/style.scss";

function App() {
  const [selectedEvent, setEvent] = useState(null);
 

  const onEventSelected = (id) => {
    setEvent(id);
  };

  return (
    <div className="app__wrapper">
      
      <AppHeader />
      <main>
        <SearchPanel />
        <div className="events__content">
          <EventsList onEventSelected={onEventSelected} />
          <EventInfo eventId={selectedEvent} />
        </div>
      </main>
    </div>
  );
}

export default App;
