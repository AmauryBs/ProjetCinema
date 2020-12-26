export class Film {
    constructor(
        public  noFilm : number,
        public  titre : string,
        public  duree: number,
        public  dateSortie: Date,
        public  budget: number,
        public  montantRecette: number,
        public realisateur:  {NoRea: number,
                            NomRea: string,
                            PrenRea: string},
        public categorie: {CodeCat: string,
                            LibelleCat: string,
                            image:string},
    ) {}
    }
       

        
    
    

  