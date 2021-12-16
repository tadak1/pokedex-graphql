import SwiftUI
import shared

struct ContentView: View {
	let greet = Greeting().greeting()
	var body: some View {
		Text(greet)
        Button(action: {
            pokemons()
        }){
            Text(greet)
        }
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}

func pokemons() {
    let pokemon = PokemonClient().getPokemons(completionHandler: { pokemons, err in
        print(pokemons)
        
    })
}
