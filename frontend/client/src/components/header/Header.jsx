import "./header.scss";
import events from '../../resources/events1.jpg'

export default function Header() {
  return (
    <div className="header">
      <img className="header-img" src={events} alt="" />
    </div>
  );
}
