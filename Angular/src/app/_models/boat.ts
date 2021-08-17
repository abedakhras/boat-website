import { Shipyard, BoatType, BoatModel } from '.';

export class Boat {
  constructor(
    name: string,
    shipyardCountry: string,
    shipyardName: string,
    modelModel: string,
    modelYaer: string,
    size: number,
    type: BoatType) {
      this.name=name;
      this.shipyard={country:shipyardCountry,name:shipyardName};
      this.model={model:modelModel,year:modelYaer};
      this.size=size
      this.type=type
  }
  id: string;
  name: string;
  shipyard: Shipyard;
  model: BoatModel;
  size: number;
  type: BoatType;
}
