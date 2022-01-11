const SearchPanel = () => {
  return (
    <div className="search__container">
      <input
        type="text"
        className="search__input"
        placeholder="Найти мероприятие"
      />
      <button className="button search__button">Найти</button>
    </div>
  );
};

export default SearchPanel;
