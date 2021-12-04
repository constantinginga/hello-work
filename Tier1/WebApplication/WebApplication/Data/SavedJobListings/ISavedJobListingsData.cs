using System.Collections.Generic;
using System.Threading.Tasks;
using WebApplication.Models;

namespace WebApplication.Data.SavedJobListings
{
    public interface ISavedJobListingsData
    {
        Task<SavedJobListing> CreateSavedJobListing(SavedJobListing savedJobListing);
        Task RemoveSavedJobListing(SavedJobListing savedJobListing);
        Task<IList<SavedJobListing>> GetSavedJobListings();
    }
}