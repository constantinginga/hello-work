using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.Json;
using System.Threading.Tasks;
using WebApplication.Models;
using WebApplication.Pages;

namespace WebApplication.Data.SavedJobListings
{
    public class SavedJobListingsData : ISavedJobListingsData
    {       
        private WebApiUtil _client;
        public IList<SavedJobListing> savedJobListings { get; private set; }
        
        private const string _url = "http://localhost:8082/saved";
        
        public SavedJobListingsData()
        {
            savedJobListings = new List<SavedJobListing>();
            _client = new WebApiUtil(_url);
        }
        public async Task<SavedJobListing> CreateSavedJobListing(SavedJobListing savedJobListing)
        {
            Random rand = new Random();
            savedJobListing.Id = rand.Next();
            savedJobListings.Add(savedJobListing);
            string serializeSavedJobListing = JsonSerializer.Serialize(savedJobListing);
            string response = await _client.Post("", serializeSavedJobListing);
            SavedJobListing saved = JsonSerializer.Deserialize<SavedJobListing>(response, new JsonSerializerOptions()
            {
            });
            return saved;
        }

        public async Task RemoveSavedJobListing(SavedJobListing savedJobListing)
        {
            savedJobListings.Remove(savedJobListings.First(listing => listing.Id == savedJobListing.Id));

            string response = await _client.Delete("?id=" + savedJobListing.Id);

            if (response.Equals("Not Found"))
            {
                throw new Exception("Not Found");
            }

        }

        public async Task<IList<SavedJobListing>> GetSavedJobListings()
        {
            // load once and store in variable
            if (!savedJobListings.Any())
            {
                string responese = await _client.Get("");
                savedJobListings = JsonSerializer.Deserialize<List<SavedJobListing>>(responese, new JsonSerializerOptions()
                {
                });
                
            }

            return savedJobListings;
        }
    }
}